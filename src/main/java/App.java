import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;

public class App {
    public static void main(String[] args) throws Exception {

        Repository repository = org.apache.jackrabbit.commons.JcrUtils.getRepository("http://localhost:4502/crx/server");
        javax.jcr.Session session = repository.login( new SimpleCredentials("admin", "admin".toCharArray()));

        Node root = session.getRootNode();

        NodeIterator nodeIterator = root.getNodes();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.nextNode();
            System.out.println(node.getPath());
        }

        // Save the session changes and log out
        session.save();
        session.logout();
    }
}
