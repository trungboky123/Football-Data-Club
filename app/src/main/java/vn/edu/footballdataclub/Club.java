package vn.edu.footballdataclub;

public class Club {
    public int rank;
    public String name;
    public String country;
    public int point;
    public int logoRes;
    public int flagRes;

    public Club(int rank, String name, String country, int point, int logoRes, int flagRes) {
        this.rank = rank;
        this.name = name;
        this.country = country;
        this.point = point;
        this.logoRes = logoRes;
        this.flagRes = flagRes;
    }
}
