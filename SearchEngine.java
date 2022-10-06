import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> stringsToAdd = new ArrayList<String>() ;

    public String handleRequest(URI url) {

        if (url.getPath().equals("/")) {
            return String.format("List of Strings:", stringsToAdd);
        } else if (url.getPath().contains("/add")) {
            String givenString = url.getQuery().split("=")
            stringsToAdd.add(givenString);
            return ArrayList<String>.format()
        } 
        //else {
            //System.out.println("Path: " + url.getPath());
            //if (url.getPath().contains("/add")) {
                //String[] parameters = url.getQuery().split("=");
                //if (parameters[0].equals("count")) {
                    //num += Integer.parseInt(parameters[1]);
                    //return String.format("Number increased by %s! It's now %d", parameters[1], num);
                //}
            //}
            //return "404 Not Found!";
        //}
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}