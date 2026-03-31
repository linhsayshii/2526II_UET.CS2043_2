import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HelpCenter {
    static class Customer {
        String id;
        String name;
        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    static class Message {
        String id;
        String content;
        public Message(String id, String content) {
            this.id = id;
            this.content = content;
        }
    }
    static class Ticket {
        String id;
        String content;
        long timestamp;
        Customer customer;
        public Ticket(String id, Customer customer, String content, long timestamp) {
            this.id = id;
            this.customer = customer;
            this.content = content;
            this.timestamp = timestamp;
        }
    }
    
    static class CustomerQueue {
        private Queue<Ticket> queue = new LinkedList<>();
        public void addRequest(Ticket ticket) {
            queue.offer(ticket);
            System.out.println("Ticket has been added to queue");
        }
        public Ticket processNextTicket() {
            Ticket nextTicket = queue.poll();
            if (nextTicket==null) {
                System.out.println("No tickets in queue");
                return null;
            } else {
                System.out.println("Processing ticket: " + nextTicket.id);
                return nextTicket;
            }   
        }
    }
    static class MessageHistory {
        private Stack<Message> stack = new Stack<>();
        public void typeMessage(Message message) {
            stack.push(message);
            System.out.println("Message has been added to history");
        }
        public void undo() {
            if (!stack.isEmpty()) {
                Message removed = stack.pop();
                System.out.println("Undo message: " + removed.content);
            } else {
                System.out.println("[Undo] No messages in history");
            }
        }
        public void viewLast() {
            if (!stack.isEmpty()) {
                System.out.println("Last message: " + stack.peek().content);
            } else {
                System.out.println("[View] No messages in history");
            }
        }
    }
}
