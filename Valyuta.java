package entty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Valyuta {
    private int id;
    private String Code;
    private String Ccy;
    private String CcyNm_RU;
    private String CcyNm_UZ;
    private String CcyNm_EN;
    private String CcyNm_UZC;
    private String Nominal;
    private String Rate;
    private String Diff;
    private String Date;

    @Override
    public String toString() {
        return  "id=" + id + '\n' +
                "Code=" + Code + '\n' +
                "Ccy=" + Ccy + '\n' +
                "CcyNm_RU=" + CcyNm_RU + '\n' +
                "CcyNm_UZ=" + CcyNm_UZ + '\n' +
                "CcyNm_EN=" + CcyNm_EN + '\n' +
                "CcyNm_UZC=" + CcyNm_UZC + '\n' +
                "Nominal=" + Nominal + '\n' +
                "Rate" + Rate + '\n' +
                "Diff=" + Diff + '\n' +
                "Date=" + Date + '\n' ;
    }
}
