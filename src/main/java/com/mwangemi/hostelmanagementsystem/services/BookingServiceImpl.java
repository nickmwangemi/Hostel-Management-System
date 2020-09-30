package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.Booking;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.MpesaConfig.Constants;
import com.mwangemi.hostelmanagementsystem.models.MpesaConfig.Mpesa;
import com.mwangemi.hostelmanagementsystem.models.Room;
import com.mwangemi.hostelmanagementsystem.models.StkRequest;
import com.mwangemi.hostelmanagementsystem.repositories.BookingRepository;
import com.mwangemi.hostelmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    RoomRepository roomRepository;
    Mpesa mpesa = new Mpesa(Constants.APP_KEY,Constants.APP_SECRET);

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public GenericResponse save(Booking booking) throws IOException {
        Optional<Room> room = roomRepository.findById(booking.getRoom().getId());
        if(room.isPresent()){
            booking.setRoom(room.get());
            Booking bookingToSave = bookingRepository.save(booking);

            StkRequest stkRequest = new StkRequest();
            stkRequest.setBusinessShortCode("174379");
            stkRequest.setPassword("MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwODI1MTk1MDAw");
            stkRequest.setTimestamp("20200825195000");
            stkRequest.setTransactionType("CustomerPayBillOnline");
            stkRequest.setAmount("1");
            stkRequest.setPhoneNumber("254794721438");
            stkRequest.setPartyA("254794721438");
            stkRequest.setPartyB("174379");
            stkRequest.setCallBackURL("https://354bfd70899f.ngrok.io/mpesa/callback");
            stkRequest.setQueueTimeOutURL("https://354bfd70899f.ngrok.io/mpesa/callback");
            stkRequest.setAccountReference("Hostel Service");
            stkRequest.setTransactionDesc("hostel booking");

            mpesa.STKPushSimulation(stkRequest);
            
            return new GenericResponse(200, "Request Successful. Booking Created", bookingToSave);
        }
        return new GenericResponse(400, "Not Saved");
    }


    @Override
    public GenericResponse listAll() {
        List<Booking> bookingList=bookingRepository.findAll();
        if (bookingList.size() > 0){
            return new GenericResponse(200,"Request Successful. Fetched bookings.",bookingList);
        }
        return new GenericResponse(400,"No Data Found");
    }



    @Override
    public GenericResponse get(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Booking record fetched.",bookingOptional);
        return new GenericResponse(400,"Request Failed! No Booking details found or error");
    }

    @Override
    public GenericResponse update(Long id, Booking booking) {
        Optional<Booking> bookingToUpdate = bookingRepository.findById(id);
        Room room = bookingToUpdate.get().getRoom();

        if (bookingToUpdate.isPresent()) {
            bookingToUpdate.get().setRoom(booking.getRoom());
            bookingToUpdate.get().setAmount(booking.getAmount());
            bookingToUpdate.get().setDateOfBooking(booking.getDateOfBooking());

            Booking updated = bookingRepository.save(bookingToUpdate.get());
            return new GenericResponse(200,"Request Successful. Booking record updated.",updated);
        }
        return new GenericResponse(400,"Request Failed! Booking not updated.");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        Optional<Booking> bookingToDelete = bookingRepository.findById(id);
        if(bookingToDelete.isPresent()) {
            bookingRepository.delete(bookingToDelete.get());
            return new GenericResponse(200, "Request Successful. Booking record deleted.");
        }
        return new GenericResponse(400, "Request Failed! Booking record not deleted.");

    }

}













