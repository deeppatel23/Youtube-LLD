package FactoryDP.BadCode;

class Application {

    // Client code directly creating objects
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification("abc@gmail.com");
        email.send();

        SMSNotification sms = new SMSNotification();
        sms.send();

        EmailNotification email2 = new EmailNotification("xyz@gmail.com");
        email2.send();

        // Imagine adding WhatsApp, Push, etc – nightmare!
    }
}
