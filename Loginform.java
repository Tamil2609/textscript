package selenium.textscript;

import selenium.Loginalert;

public class Loginform extends Loginalert
{

    public static void main(String args[]) throws Exception
    { Loginform log=new Loginform();

        log.Start();
        log.senddata();
        log.test();
        log.close();

    }
}

