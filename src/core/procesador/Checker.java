/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.procesador;

/**
 *
 * @author mauriballes
 */
public class Checker {

    private Anacom anacom;
    public boolean errorFlag;

    public Checker(Anacom anacom) {
        this.anacom = anacom;
    }

    public void Expresion() {
        this.errorFlag = false;
        if (anacom.Preanalisis().getNombre() == Token.HELP) {
            match(Token.HELP);
        } else {
            match(Token.FUNC);
            acomp();
        }
    }

    public void acomp() {
        if (anacom.Preanalisis().getNombre() == Token.CA) {
            match(Token.CA);
            parametros();
            match(Token.CC);
        } else if (anacom.Preanalisis().getNombre() == Token.HELP) {
            match(Token.HELP);
        }
    }

    public void parametros() {
        param();
        masparam();
    }

    public void param() {
        switch (anacom.Preanalisis().getNombre()) {
            case Token.STRING:
                match(Token.STRING);
                break;
            case Token.NUM:
                match(Token.NUM);
                break;
            case Token.TRUE:
                match(Token.TRUE);
                break;
            case Token.FALSE:
                match(Token.FALSE);
                break;
            default:
                match(Token.GB);
                break;
        }
    }

    public void masparam() {
        if (anacom.Preanalisis().getNombre() == Token.COMA) {
            match(Token.COMA);
            param();
            masparam();
        }
    }

    public void match(int token) {
        if (anacom.Preanalisis().getNombre() == token) {
            anacom.Avanzar();
        } else {
            System.out.println("Error en Checker al procesar Token!");
            this.errorFlag = true;
        }
    }

    public void Init() {
        anacom.Init();
    }
}
