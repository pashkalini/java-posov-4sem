package exam;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductTest {
    public static void main(String[] args) throws IOException {
        System.out.println(findFiles());
        createProduct();

        sortProducts(createProduct());
    }

    private static ArrayList<String> findFiles() throws IOException {
        String fileName;
        boolean extFile;
        File directory = new File("C:\\Users\\pashk\\OneDrive\\SPbU\\2 курс\\Programming\\Code1" +
                "\\src\\exam\\food");
        File[] list = directory.listFiles();
        ArrayList<String> txtFiles = new ArrayList<>();

        assert list != null;
        for (File f : list) {
            if (f.isFile()) {
                fileName = f.getName();
                extFile = fileName.endsWith("txt");
                if (extFile) {
                    txtFiles.add(f.getCanonicalPath());
                }
            }
        }
        return txtFiles;
    }

    private static ArrayList<Product> createProduct() throws IOException {
        ArrayList<String> txtFiles = findFiles();
        ArrayList<Product> productsList = new ArrayList<>();

        for (String path : txtFiles) {
            Pattern pattern = Pattern.compile("food.+txt");

            Matcher matcher = pattern.matcher(path);
            String category = "";

            while (matcher.find()) {
                category = path.substring(matcher.start(), matcher.end());
            }
            System.out.println(category);

            try (
                    Scanner text = new Scanner(Paths.get(path), StandardCharsets.UTF_8)
            ) {
                while (text.hasNextLine()) {
                    String line = text.nextLine();
                    Scanner lineScanner = new Scanner(line);
                    StringBuilder name = new StringBuilder();
                    float price = 0;

                    while (lineScanner.hasNext()) {
                        String product;

                        if (!(lineScanner.hasNextFloat())) {
                            product = lineScanner.next();
                            name.append(product);
                            System.out.println(product);
                        } else {
                            price = lineScanner.nextFloat();
                            System.out.println(price);
                        }
                    }
                    productsList.add(new Product(category, name.toString(), price));
                }
            }
        }

        for (Product pr : productsList) {
            System.out.println(pr.toString());
        }
        return productsList;
    }

    private static void sortProducts(ArrayList<Product> productsList) throws IOException {
        ArrayList<String> presortedProductsLlist = new ArrayList<>();

        for (Product pr : productsList) {
            presortedProductsLlist.add(String.format("%s %.2f (%s)", pr.getName(), pr.getPrice(), pr.getCategory()));
        }

        Collections.sort(presortedProductsLlist);

        try (
                PrintStream fout = new PrintStream("sortedTitles.txt", StandardCharsets.UTF_8)
        ) {
            for (String product : presortedProductsLlist)
                fout.println(product);
        }
    }

}
