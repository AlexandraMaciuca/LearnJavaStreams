import java.util.List;

public class Message {

    private String sender;
    private String receiver;
    private String message;

    public Message(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long messageCount (List<Message> msg , String user) {
        return msg.stream()
                .filter(m -> m.getSender().equals(user))
                .count();
    }

    @Override
    public String toString() {
        return sender + " to " + receiver + " : " + message;
    }
}
