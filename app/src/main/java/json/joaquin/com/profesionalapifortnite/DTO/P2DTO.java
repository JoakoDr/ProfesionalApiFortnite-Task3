package json.joaquin.com.profesionalapifortnite.DTO;

public class P2DTO {
    private ObjectDTO trnRating;
    private ObjectDTO score;
    private ObjectDTO top1;
    private ObjectDTO top3;

    public ObjectDTO getTrnRating() {
        return trnRating;
    }

    public void setTrnRating(ObjectDTO trnRating) {
        this.trnRating = trnRating;
    }

    public ObjectDTO getScore() {
        return score;
    }

    public void setScore(ObjectDTO score) {
        this.score = score;
    }

    public ObjectDTO getTop1() {
        return top1;
    }

    public void setTop1(ObjectDTO top1) {
        this.top1 = top1;
    }

    public ObjectDTO getTop3() {
        return top3;
    }

    public void setTop3(ObjectDTO top3) {
        this.top3 = top3;
    }

    public P2DTO()
    {
        this.trnRating = trnRating;
        this.score = score;
        this.top1 = top1;
        this.top3 = top3;
    }

}
