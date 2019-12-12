package ub.edu.model;

public class ValoracionsEstrelles extends Valoracions {
    private static final int  MIN_STARS = 1,MAX_STARS = 5;
    private int value;

    public ValoracionsEstrelles(String usuariId, String episodi){
        super(usuariId,episodi);
    }
    @Override
    public boolean setValue(int value){
        if(value >= MIN_STARS && value <= MAX_STARS){
            this.value = value;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.getEpisodi()+" valorat amb "+value+" estrelles";
    }
}
