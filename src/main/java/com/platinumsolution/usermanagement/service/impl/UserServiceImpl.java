package com.platinumsolution.usermanagement.service.impl;

import com.platinumsolution.usermanagement.dto.UserDTO;
import com.platinumsolution.usermanagement.entity.User;
import com.platinumsolution.usermanagement.repository.UserRepository;
import com.platinumsolution.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private int gnNumber = 0;
    int m = 0;
    int n = 0;
    int activeSts = 0;

    private int dfltStatus = 0;
    private String sendMail = "";

    @Autowired
    private UserRepository uRepo;

    private JavaMailSender javaMailSender;

    public UserServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    @Override
    public boolean regUser(UserDTO userDTO) throws MailException {

        // get gnNumber Method
        gnNumber();

        // save user
        User user = new User(userDTO.getUserMobile(),userDTO.getUserEmail(),userDTO.getUserPassword(),dfltStatus,gnNumber);

        if (userDTO.getUserMobile() == null
                || userDTO.getUserEmail() == null || userDTO.getUserPassword() == null) {
            sendMail = null;
            throw new RuntimeException("some column has a null !");
        } else {
            sendMail = userDTO.getUserEmail();
        }

        if (sendMail.equals("") || sendMail.equals(null)) {
            throw new RuntimeException("set Mail To .... !");
        } else {

            // send OTP code to user entered email
            SimpleMailMessage simpleMail = new SimpleMailMessage();
            simpleMail.setTo(sendMail);
            simpleMail.setFrom("");// please add sender mail here
            simpleMail.setText("This is youre OTP :-" + gnNumber);// send random generate number as OTP
            simpleMail.setSubject("Online Shopping Account Verify Email.");
            javaMailSender.send(simpleMail);

        }

        uRepo.save(user);

        return true;
    }

    // generate 7 digit random code
    private void gnNumber() {
        Random r = new Random();
        gnNumber = r.nextInt(10000000);
        System.out.println("random 7 digit number:" + gnNumber);
    }

    @Transactional
    @Override
    public boolean activatAcc(int gnNumber) {
        // check default active user by user entered OTP
        String qry = uRepo.findUserByStatusNative(activeSts, gnNumber);
        System.out.println(qry);
        if (qry == null) {
            throw new RuntimeException("invalid OTP try again..");
        } else {
            // user entered OTP == send OTP, user account activated
            activeSts = 1;
            uRepo.updateUserSetStatusForName(activeSts, gnNumber);
        }
        activeSts = 0;
        return true;
    }
}
