package model;

public class ValoracionsThumb extends Valoracions {

    public ValoracionsThumb(String usuariId, String episodi){
        super(usuariId,episodi);
    }

    @Override
    public boolean setValue(int value) {
        if(value == 1 || value == 0){
            this.value = value;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(value == 1)
            return this.getEpisodi()+" valorat amb\uD83D\uDC4D\n";
        else
            return this.getEpisodi()+" valorat amb\uD83D\uDC4E\n";

    }
}
