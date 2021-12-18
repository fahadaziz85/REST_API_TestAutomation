import files.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStore {

    // Objective of this class example is to learn how to parse complex JSONs and perform tests on it.

    @Test
    public void testBookStore() {
        JsonPath js = new JsonPath(PayLoad.coursePrice());

        int coursesCount = js.getInt("courses.size()"); // This methode will give you the size of the array
        System.out.println("Number of courses available in Json: " + coursesCount); // Print Number of courses returned by API

        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount: " + purchaseAmount); // Print the total purchase amount returned by API

        String titleFirstCourse = js.getString("courses[0].title");
        System.out.println(titleFirstCourse);
        int sum = 0;
        for (int i = 0; i<coursesCount; i++){ // for loop

                String courseTitle = js.getString("courses[" + i + "].title"); // courses is in js object, so you don't need to worry about how to convert in to String 2d array
                System.out.println("Book Title: " + courseTitle);
                int bookCount = js.getInt("courses[" + i + "].copies");
                System.out.println("Book Copies: " + bookCount);
                int price = js.getInt("courses[" + i + "].price");
                System.out.println("Book Price: " + price);

                sum+= bookCount*price;
                if(courseTitle.equals("RPA")){
                    System.out.println("Test number 5 result: " + bookCount);
                }

        }
        System.out.println("Here is the total sum of books prices: " + sum);
        Assert.assertEquals(sum, purchaseAmount);


    }
}
