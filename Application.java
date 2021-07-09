package uz;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entty.Valyuta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void ShowAll(List<Valyuta>valyutaList)
    {
        for (int i = 0; i < valyutaList.size(); i++) {
            System.out.print((i+1)+" - "+valyutaList.get(i).getCcy()+"\t\t");
            if ((i+1)%9==0)
            {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        final String URL_PATH="https://cbu.uz/oz/arkhiv-kursov-valyut/json/";
        Scanner scanner=new Scanner(System.in);
        List<Valyuta>valyutaList=new ArrayList<Valyuta>();
        int valyuta1,valyuta2,k=0;
        double summa1,summa2;

        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader bufferedReader=null;
        Gson gson=new Gson();

        try {
            url=new URL(URL_PATH);
            urlConnection=url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type=new TypeToken<ArrayList<Valyuta>>(){}.getType();
            valyutaList=gson.fromJson(bufferedReader,type);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null)
            {
                bufferedReader.close();
            }
        }


       while (k!=-1) {
           System.out.println("0=>Chiqish\n1=>Valyutalar ro'yxati\n2=>Convert\n3=>Valyuta haqid ma'lumot");
            k=scanner.nextInt();
           switch (k) {
               case 0: break;
               case 1: ShowAll(valyutaList); break;
               case 2:
                   ShowAll(valyutaList);
                   System.out.println("Valyutani tanlang : ");
                   valyuta1 = scanner.nextInt() - 1;

                   System.out.println("Qaysi valyutaga o'tkazmoqchimisiz tanlang : ");
                   valyuta2 = scanner.nextInt() - 1;

                   System.out.println("Mablag' miqdorini kiriting : ");
                   summa1 = scanner.nextDouble();
                   summa2=Double.parseDouble(valyutaList.get(valyuta1).getRate())*summa1;
                   summa2 /=Double.parseDouble(valyutaList.get(valyuta2).getRate());
                   System.out.println(summa1+" "+valyutaList.get(valyuta1).getCcy()+" = "+summa2+" "+valyutaList.get(valyuta2).getCcy());
               break;
               case 3:
                   ShowAll(valyutaList);
                   System.out.print("Kerakli valyutani tanlang : ");
                   valyuta1=scanner.nextInt();

                   System.out.println(valyutaList.get(valyuta1).toString());
                    break;
               default:
                   System.out.println("Bunday buyruq mavjud emas ");
           }

       }







    }
}
