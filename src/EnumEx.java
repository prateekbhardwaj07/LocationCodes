enum Week {
  Monday, Tuesday, Wednesday, Thursday, Friday, Saturaday, Sunday
}

public class  EnumEx {
  public static void main(String args[]) {
    System.out.println("Here are all Week constants");

    // use values()
    Week allWeek = Week.values()[0];
    /*for(Week aday:allWeek)
     {
      System.out.println(aday);
    }*/
    System.out.println(allWeek);

  }
}