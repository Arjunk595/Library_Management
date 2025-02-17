import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Library{

    private String book_name;
    private int book_id;
    private int copies;
    public Library(String book_name,int book_id,int copies){
        this.book_name=book_name;
        this.book_id=book_id;
        this.copies=copies;
    }
    
    

    public String getBook_name() {
        return book_name;
    }



    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }



    public int getBook_id() {
        return book_id;
    }



    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCopies() {
        return copies;
    }



    public void setCopies(int copies) {
        this.copies = copies;
    }



    @Override
    public String toString() {
        return "Library [book_name=" + book_name + ", book_id=" + book_id + ", copies=" + copies + "]";
    }    

}
class Studentrecord{
    private String name;
    private int book_id;
    //private String bookname;
    public Studentrecord(String name,int book_id) {
        this.name=name;
        this.book_id=book_id;
    }
    
    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getBook_id() {
        return book_id;
    }



    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }



    @Override
    public String toString() {
        return "Student [name=" + name + ", book_id=" + book_id + "]";
    }
    
}
public class LibraryManagement {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //list for books in library
        List <Library> books=new ArrayList<>();
        //list for student record who borrowed books
        List <Studentrecord> std=new ArrayList<>();
        books.add(new Library("setu",1,4));
        books.add(new Library("aryabhatt",2,4));
        books.add(new Library("geeta",3,4 ));
        books.add(new Library("ramayana",4,4));
        books.add(new Library("rakta charitra",5,4));
        books.add(new Library("kalki",6,4 ));

        char ans;
        do { 
            System.out.println("Welcome to Library");
            System.out.println("1.Display the books in library");
            System.out.println("2.borrow the book");
            System.out.println("3.Record of student who borrowed book from library");
            System.out.println("4.Return the book");
            System.out.println();
            System.out.print("Enter your choice :");
            int choice=sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    for(Library lib:books){
                    System.out.println(lib);
                    }
                    break;
                case 2:
                    System.out.print("enter yur name: ");
                    String name=sc.next();
                    System.out.println();
                    System.out.print("enter the id of book you want to Borrow: ");
                    int id=sc.nextInt();
                    System.out.println();

                    Boolean flag=false;
                    for(Library lib:books){
                        if(lib.getBook_id()==id && lib.getCopies()>0){
                        std.add(new Studentrecord(name, id));
                        System.out.println("book has issued");
                        lib.setCopies(lib.getCopies()-1);
                        flag=true;
                        break; 
                        }    
                    }
                    if(flag==false){
                        System.out.println("Book is not available in library. You can Explore Another books");
                    }
                    break;
                case 3:
                        System.out.println("here is the record of student who borrowed book from library");
                        System.out.println();
                        int borrowflag=0;
                        for(Studentrecord i:std){
                            System.out.println(i);
                            borrowflag=1;
                        }
                        if(borrowflag==0){
                            System.out.println("Not any students have borrowed book");
                        }
                        break;
                case 4:
                        String stdname;
                        System.out.print("enter you name :");
                        stdname=sc.next();
                        System.out.println();
                        System.out.print("enter the id of book you want to return:");
                        int stdid=sc.nextInt();
                        System.out.println();
                        int returnflag=0;
                        for(Studentrecord i:std){
                            if(stdname.equals(i.getName()) && stdid==(i.getBook_id())){
                                std.remove(i);
                                for(Library li:books){
                                    if(li.getBook_id()==stdid){
                                        li.setCopies(li.getCopies()+1);
                                    }
                                }
                                System.out.println("your book has returned");
                                returnflag=1;
                                break;
                            }
                        }
                        if(returnflag==0){
                            System.out.println("you have not borrowed any book. first borrow the book");
                        }

                        break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Do you want to continue y/n?");
            ans=sc.next().charAt(0);
        } while (ans=='y');
    }
}