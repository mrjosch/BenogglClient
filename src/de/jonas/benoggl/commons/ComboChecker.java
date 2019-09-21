package de.jonas.benoggl.commons;


import de.jonas.benoggl.json.Card;

import java.util.ArrayList;

public class ComboChecker {

    public static boolean checkDoppelterBinokel(ArrayList<Card> cards) {
        int shellUnter = 0;
        int blattOber = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.UNTER)) {
                shellUnter++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.OBER)) {
                blattOber++;
            }
        }

        return shellUnter == 2 && blattOber == 2;
    }

    public static boolean checkBinokel(ArrayList<Card> cards) {
        int shellUnter = 0;
        int blattOber = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.UNTER)) {
                shellUnter++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.OBER)) {
                blattOber++;
            }
        }

        return (shellUnter >= 1 && blattOber == 1) || (shellUnter == 1 && blattOber >= 1);
    }

    public static boolean checkVierAss(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.ASS)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.ASS)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.ASS)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.ASS)) {
                eichel++;
            }
        }

        return shell >= 1 && blatt >=1 && herz >= 1 && eichel >= 1;
    }

    public static boolean checkVierKoenige(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.KÖNIG)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.KÖNIG)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.KÖNIG)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.KÖNIG)) {
                eichel++;
            }
        }

        return shell >= 1 && blatt >=1 && herz >= 1 && eichel >= 1;
    }

    public static boolean checkVierOber(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.OBER)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.OBER)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.OBER)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.OBER)) {
                eichel++;
            }
        }

        return shell >= 1 && blatt >=1 && herz >= 1 && eichel >= 1;
    }

    public static boolean checkVierUnter(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.UNTER)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.UNTER)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.UNTER)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.UNTER)) {
                eichel++;
            }
        }

        return shell >= 1 && blatt >=1 && herz >= 1 && eichel >= 1;
    }

    public static boolean checkAchtAss(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.ASS)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.ASS)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.ASS)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.ASS)) {
                eichel++;
            }
        }

        return shell == 2 && blatt == 2 && herz == 2 && eichel == 2;
    }

    public static boolean checkAchtKoenige(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.KÖNIG)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.KÖNIG)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.KÖNIG)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.KÖNIG)) {
                eichel++;
            }
        }

        return shell == 2 && blatt == 2 && herz == 2 && eichel == 2;
    }

    public static boolean checkAchtOber(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.OBER)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.OBER)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.OBER)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.OBER)) {
                eichel++;
            }
        }

        return shell == 2 && blatt == 2 && herz == 2 && eichel == 2;
    }

    public static boolean checkAchtUnter(ArrayList<Card> cards) {
        int shell = 0;
        int blatt = 0;
        int herz = 0;
        int eichel = 0;

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && card.getName().equals(Cardname.UNTER)) {
                shell++;
            } else if(card.getType().equals(Cardtype.BLATT) && card.getName().equals(Cardname.UNTER)) {
                blatt++;
            } else if(card.getType().equals(Cardtype.HERZ) && card.getName().equals(Cardname.UNTER)) {
                herz++;
            } else if(card.getType().equals(Cardtype.EICHEL) && card.getName().equals(Cardname.UNTER)) {
                eichel++;
            }
        }

        return shell == 2 && blatt == 2 && herz == 2 && eichel == 2;
    }


    public static ArrayList<Cardtype> checkFamilie(ArrayList<Card> cards) {
        ArrayList<Cardtype> fams = new ArrayList<>();

        ArrayList<Card> shell = new ArrayList<>();
        ArrayList<Card> blatt = new ArrayList<>();
        ArrayList<Card> herz = new ArrayList<>();
        ArrayList<Card> eichel = new ArrayList<>();

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL)) {
                shell.add(card);
            } else if(card.getType().equals(Cardtype.BLATT)) {
                blatt.add(card);
            } else if(card.getType().equals(Cardtype.HERZ)) {
                herz.add(card);
            } else if(card.getType().equals(Cardtype.EICHEL)) {
                eichel.add(card);
            }
        }

        if(shell.size() > 4) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : shell) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                fams.add(Cardtype.SHELL);
            }
        }

        if(eichel.size() > 4) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : eichel) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                fams.add(Cardtype.EICHEL);
            }
        }

        if(herz.size() > 4) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : herz) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                fams.add(Cardtype.HERZ);
            }
        }

        if(blatt.size() > 4) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : blatt) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                fams.add(Cardtype.BLATT);
            }
        }

        return fams;
    }

    public static Cardtype checkDoppelteFamilie(ArrayList<Card> cards) {
        ArrayList<Card> shell = new ArrayList<>();
        ArrayList<Card> blatt = new ArrayList<>();
        ArrayList<Card> herz = new ArrayList<>();
        ArrayList<Card> eichel = new ArrayList<>();

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL)) {
                shell.add(card);
            } else if(card.getType().equals(Cardtype.BLATT)) {
                blatt.add(card);
            } else if(card.getType().equals(Cardtype.HERZ)) {
                herz.add(card);
            } else if(card.getType().equals(Cardtype.EICHEL)) {
                eichel.add(card);
            }
        }

        if(shell.size() > 9) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : shell) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                return Cardtype.SHELL;
            }
        }

        if(eichel.size() > 9) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : eichel) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                return Cardtype.EICHEL;
            }
        }

        if(herz.size() > 9) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : herz) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                return Cardtype.HERZ;
            }
        }

        if(blatt.size() > 9) {
            int ass = 0;
            int zehn = 0;
            int koenig = 0;
            int ober = 0;
            int unter = 0;

            for(Card card : blatt) {
                if(card.getName().equals(Cardname.ASS)) {
                    ass++;
                } else if(card.getName().equals(Cardname.ZEHN)) {
                    zehn++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                } else if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.UNTER)) {
                    unter++;
                }
            }

            if(ass >= 1 && zehn >= 1 && koenig >= 1 && ober >= 1 && unter >= 1) {
                return Cardtype.BLATT;
            }
        }

        return null;
    }

    public static ArrayList<Cardtype> checkPaar(ArrayList<Card> cards) {
        ArrayList<Cardtype> pairs = new ArrayList<>();

        ArrayList<Card> shell = new ArrayList<>();
        ArrayList<Card> blatt = new ArrayList<>();
        ArrayList<Card> herz = new ArrayList<>();
        ArrayList<Card> eichel = new ArrayList<>();

        for(Card card : cards) {
            if(card.getType().equals(Cardtype.SHELL) && (card.getName().equals(Cardname.OBER)|| card.getName().equals(Cardname.KÖNIG))) {
                shell.add(card);
            } else if(card.getType().equals(Cardtype.EICHEL) && (card.getName().equals(Cardname.OBER)|| card.getName().equals(Cardname.KÖNIG))) {
                eichel.add(card);
            } else if(card.getType().equals(Cardtype.BLATT) && (card.getName().equals(Cardname.OBER)|| card.getName().equals(Cardname.KÖNIG))) {
                blatt.add(card);
            } else if(card.getType().equals(Cardtype.HERZ) && (card.getName().equals(Cardname.OBER)|| card.getName().equals(Cardname.KÖNIG))) {
                herz.add(card);
            }
        }

        if(shell.size() > 1) {
            int ober = 0;
            int koenig = 0;

            for(Card card : shell) {
                if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                }
            }

            if((ober  == 1 && koenig > 0) || (ober > 0 && koenig == 1)) {
                pairs.add(Cardtype.SHELL);
            } else if(ober == 2 && koenig == 2) {
                pairs.add(Cardtype.SHELL);
                pairs.add(Cardtype.SHELL);
            }
        }

        if(eichel.size() > 1) {
            int ober = 0;
            int koenig = 0;

            for(Card card : eichel) {
                if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                }
            }

            if((ober  == 1 && koenig > 0) || (ober > 0 && koenig == 1)) {
                pairs.add(Cardtype.EICHEL);
            } else if(ober == 2 && koenig == 2) {
                pairs.add(Cardtype.EICHEL);
                pairs.add(Cardtype.EICHEL);
            }
        }

        if(herz.size() > 1) {
            int ober = 0;
            int koenig = 0;

            for(Card card : herz) {
                if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                }
            }

            if((ober  == 1 && koenig > 0) || (ober > 0 && koenig == 1)) {
                pairs.add(Cardtype.HERZ);
            } else if(ober == 2 && koenig == 2) {
                pairs.add(Cardtype.HERZ);
                pairs.add(Cardtype.HERZ);
            }
        }

        if(blatt.size() > 1) {
            int ober = 0;
            int koenig = 0;

            for(Card card : blatt) {
                if(card.getName().equals(Cardname.OBER)) {
                    ober++;
                } else if(card.getName().equals(Cardname.KÖNIG)) {
                    koenig++;
                }
            }

            if((ober  == 1 && koenig > 0) || (ober > 0 && koenig == 1)) {
                pairs.add(Cardtype.BLATT);
            } else if(ober == 2 && koenig == 2) {
                pairs.add(Cardtype.BLATT);
                pairs.add(Cardtype.BLATT);
            }
        }

        return pairs;
    }


}
