//********************************************************************
//  MusicCD.java       Authors: Chris Lemire
//
//  Provides an implementation of a class to represent a music cd.
//********************************************************************
public class MusicCD {

  private String title;
  private int price;

  /***********************************************************
    Constructs a music cd with a title and price.
  ***********************************************************/
  public MusicCD(String title, int price) {
    this.title = title;
    this.price = price;
  }

  /***********************************************************
    Returns the title of this music cd.
  ***********************************************************/
  public String getTitle() {
    return title;
  }

  /***********************************************************
    Returns the price of this music cd.
  ***********************************************************/
  public int getPrice() {
    return price;
  }

  /***********************************************************
    Returns true if this music cd is the same as the music cd being passed in.
  ***********************************************************/
  public boolean equals(Object that)
  {
    if(this == that) return true;
    if(!(that instanceof MusicCD)) return false;

    MusicCD thatMusicCD = (MusicCD) that;

    return (getPrice() == thatMusicCD.getPrice() && getTitle().equals(thatMusicCD.getTitle()));
  }

  /***********************************************************
    Returns a string representation of this music cd.
  ***********************************************************/
  public String toString() {
    return ("Music CD's title: " + title + "\tPrice: " + price);
  }
}
