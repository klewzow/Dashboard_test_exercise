package com.gmail.klewzow.Commons;

import com.gmail.klewzow.Entity.Customer;
import com.gmail.klewzow.Entity.Status;
import com.ibm.icu.text.Transliterator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@Data
public class ReaderCustomers {

    private List<File> files = new ArrayList<>();


    private Customer customer;
    private List<Customer> customersList = new ArrayList<>();

    private String emails[] = {"@gmail.com", "@ukr.net", "@baza.net", "@auto.ua", "@mywork.com"};
    private String phone;
    private Status status;
    private String country[] = {"Kiev", "Lviv", "Lutsk", "Khmelnitsky", "Uzhorod", "Kirovohrad", "Dnipropetrovsk", "Sumy"};

    private Random random = new Random();


    public String setPhone() {
        String num = random.nextInt((999 - 10) + 1) + "-" + random.nextInt((99 - 10) + 1) + "-" + random.nextInt((99 - 10) + 1);
        return num;
    }

    public List<Customer> readFiles() {

        files.add(new File("./name.txt"));
        files.add(new File("./sureName.txt"));
        files.add(new File("./company.txt"));

        List<String> name = new ArrayList<>();
        List<String> sureName = new ArrayList<>();
        List<String> company = new ArrayList<>();


        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                if (file.getName().equals("name.txt")) {
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        name.add(str);
                    }

                }
                if (file.getName().equals("sureName.txt")) {
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        sureName.add(str);
                    }

                }
                if (file.getName().equals("company.txt")) {
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        company.add(str);
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);

        for (int i = 0; i < 70; i++) {

            Customer cst = new Customer();
            String lat = toLatinTrans.transliterate(sureName.get(i).toLowerCase(Locale.ROOT));
            cst.setName(name.get(i) + " " + sureName.get(i));
            cst.setCompany(company.get(random.nextInt(company.size())));
            cst.setEmail(lat + emails[random.nextInt(emails.length - 1)]);
            cst.setCountry(country[random.nextInt(country.length - 1)]);
            cst.setPhone(setPhone());
            cst.setStatus(Status.ACTIVE);
            customersList.add(cst);
        }


//        for (Customer cst:customersList
//             ) {
//            System.out.println(cst);
//        }
        return customersList;
    }


}
