public class Main {
    public static void main(String[] args) {
        HelpCenter.CustomerQueue queue = new HelpCenter.CustomerQueue();
        HelpCenter.MessageHistory history = new HelpCenter.MessageHistory();

        //new customer A and B
        HelpCenter.Customer customer1 = new HelpCenter.Customer("1", "A");
        HelpCenter.Customer customer2 = new HelpCenter.Customer("2", "B");

        //add request
        queue.addRequest(new HelpCenter.Ticket("1", customer1, "Stability Problems", System.currentTimeMillis()));
        queue.addRequest(new HelpCenter.Ticket("2", customer2, "Payment Problems", System.currentTimeMillis()));

        //process ticket A
        queue.processNextTicket();
        history.typeMessage(new HelpCenter.Message("1", "Hello"));
        history.typeMessage(new HelpCenter.Message("2", "I'm glad to help you"));
        history.typeMessage(new HelpCenter.Message("3", "This message should be undone"));
        history.undo();

        //process ticket B
        queue.processNextTicket();
    }
}
