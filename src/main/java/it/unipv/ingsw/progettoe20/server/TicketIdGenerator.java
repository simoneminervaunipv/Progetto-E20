package it.unipv.ingsw.progettoe20.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unipv.ingsw.progettoe20.Protocol;
import it.unipv.ingsw.progettoe20.server.database.DatabaseFacade;
import it.unipv.ingsw.progettoe20.server.model.Level;

/**
 * Classe che genera i ticket
 */

public class TicketIdGenerator {
    private DatabaseFacade dbFacade;
    private final int lungId = 8;
    private List<Level> levelList;
    private int contLevel;
    private Boolean check;
    private String levelName;
    private String[] alfaCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "z", "y",
            "j", "k", "x", "w", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Z", "Y",
            "J", "K", "X", "W"};
    private String[] numCharacters = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    private Random rand = new Random();

    public TicketIdGenerator(DatabaseFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public String getAvailableLevel() {
        levelList = new ArrayList<>();
        levelList = dbFacade.getLevelList();
        contLevel = levelList.size();
        check = false;
        boolean checkLevelsAbsence;
        if (contLevel != 0) {
            checkLevelsAbsence = true;
        } else {
            checkLevelsAbsence = false;
        }
        int i = 0;
        levelName = "";
        if (!checkLevelsAbsence) {
            levelName = Protocol.RESPONSE_NO_LEVEL;
        } else {
            do {
                if (!check) {
                    if (levelList.get(i).getAvailable() != 0) {
                        levelName = levelList.get(i).getName();
                        check = true;
                    }
                }
                i++;
            } while (i < contLevel);
            if (!check) {
                levelName = Protocol.RESPONSE_NO_LEVEL;
            }
        }
        return levelName;
    }

    public String generateId() {

        // ottengo la lunghezza di ogni array
        int lungCaratteri = alfaCharacters.length;
        int lungNumeri = numCharacters.length;
        double randomPattern;
        StringBuilder randomString = new StringBuilder(getAvailableLevel());
        if (!randomString.toString().equals(Protocol.RESPONSE_NO_LEVEL)) {
            while (randomString.length() < lungId) {

                randomPattern = Math.random(); //numero casuale tra 0.0 e 1.0

                //append carattere
                if (randomPattern < 0.5) {
                    // ottengo un elemento casuale per ogni array
                    int c = rand.nextInt(lungCaratteri);
                    // aggiungo una lettera casuale
                    randomString.append(alfaCharacters[c]);
                }
                //append numero
                else {
                    int n = rand.nextInt(lungNumeri);
                    randomString.append(numCharacters[n]);
                }


            }
            // se la stringa generata dovesse superare il numero di caratteri
            // richiesto, la taglio.

            if (randomString.length() > lungId) {
                randomString = new StringBuilder(randomString.substring(0, lungId));
            }
        }

        return randomString.toString();

    }
}
