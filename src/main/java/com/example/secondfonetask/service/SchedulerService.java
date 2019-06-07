package com.example.secondfonetask.service;

import com.example.secondfonetask.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SchedulerService {
    private final UserRepositoryService userService;
    private final EmailService emailService;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMailToUsers(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<User> list = userService.getAll(month, day);
        if (!list.isEmpty()) {
            list.forEach(user -> {
                try {
                    String message = "Happy Birthday dear " + user.getName() + "!";
                    emailService.send(user.getEmail(), "Happy Birthday!", message);
                    log.info("Email have been sent. User id: {}, Date: {}", user.getId(), date);
                } catch (Exception e) {
                    log.error("Email can't be sent.User's id: {}, Error: {}", user.getId(), e.getMessage());
                    log.error("Email can't be sent", e);
                }
            });
        }
    }
}
