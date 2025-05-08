package FactoryDP.BadCode;

import java.util.Scanner;

class NotificationService {

    // Client code directly creating objects
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        email.send();

        SMSNotification sms = new SMSNotification();
        sms.send();

        // Imagine adding WhatsApp, Push, etc – nightmare!
    }
}
