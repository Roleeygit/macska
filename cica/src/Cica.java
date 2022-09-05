import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cica extends Cicacreate{
    public String nev;
    public int ehseg = -10;
    public int szomj = -5;
    private final int EHSEG_HATAR = 10;
    private final int SZOMJ_HATAR = 10;
    

    public Cica(String string) {
    }

    public void Cirmos(String nev) 
    {
        this.nev = nev;
        olvas_allapot();
    }

    @Override
    public void ertelmezo() {
      Scanner sc = new Scanner(System.in);
      String parancs = "";
      while(!parancs.equals("vege")) {
        System.out.print(this.nev + ">");
        parancs = sc.nextLine();
        //Etetés
        if(parancs.equals("etet")){
          this.ehseg = this.ehseg - 10;
        }
        if(parancs.equals("vege")){
          kiir_allapot();
        }
        if(parancs.equals("itat")){
          this.szomj = this.szomj - 3;
        }
        eheztetes();
        elet_kezeles();
        szomjaztas();
        szomj_kezeles();
        
  
        }
        sc.close();

    }

private void eheztetes() {
    //Éheztetés 
    this.ehseg ++;
    if(this.ehseg>0) 
    {
      System.out.println("Éhes vagyok!");
    }
    if(this.ehseg>5)
    {
      System.out.println("Meow mindjárt éhen halok!");
    }
 }

 private void szomjaztas() {
  //Macska szomjaztatása
  this.szomj ++;
  if(this.szomj>-1)
  {
    System.out.println("Szomjas vagyok!");
  }
  if(this.szomj>2)
  {
    System.out.println("Nagyon szomjas vagyok!");
  }

}

private void szomj_kezeles() {
  if(this.szomj>SZOMJ_HATAR) {
    System.out.println("Szomjan haltam...");
    System.exit(0);
  }
}




private void elet_kezeles() {
    if(this.ehseg> EHSEG_HATAR) {
      System.out.println("Éhen haltam...");
      System.exit(0);
    }
 }


private void kiir_allapot() 
  {
    try {
      probal_kiir_allapot();
    } catch (IOException e) {
      System.err.println("Hiba az írás során.");
    }
  }

private void probal_kiir_allapot() throws IOException {
    FileWriter fw = new FileWriter("allapot.txt", false);
    PrintWriter pw = new PrintWriter(fw);
    pw.println(this.ehseg);
    pw.close();
    fw.close();
}  


private void olvas_allapot()
 {
    try 
    {
      probal_olvas_allapot();
    } catch (FileNotFoundException e)  
    {
      System.err.println("A file nem található!");
    }
 }


private void probal_olvas_allapot() throws FileNotFoundException
 {
   File f = new File("allapot.txt");
   Scanner sc = new Scanner(f);
   String ehsegStr = sc.nextLine();
   this.ehseg = Integer.parseInt(ehsegStr);
   sc.close();
   
 }


}