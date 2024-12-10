public class NotificationFactory {
    public Notification createNotification(String notificationType) {
        switch (notificationType) {
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            case "EMAIL":
                return new EmailNotification();
        }
        return null;
    }
}