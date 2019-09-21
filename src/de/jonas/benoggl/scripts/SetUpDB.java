package de.jonas.benoggl.scripts;

import db.HSQLDatabase;
import db.utils.Column;
import db.utils.Datatype;
import db.utils.Table;
import db.utils.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

public class SetUpDB {

    public static void main(String[] args) throws SQLException {
        HSQLDatabase myDB = new HSQLDatabase("database/cards");
        myDB.create();

        myDB.connect();
        create_3_player_Combos_Table(myDB);
        myDB.disconnect();
    }

    public static void create_3_player_Table(HSQLDatabase db) throws SQLException{
        Table card_3_players = new Table("players_3");
        card_3_players.addColumn(new Column("type", Datatype.VARCHAR, 255));
        card_3_players.addColumn(new Column("name", Datatype.VARCHAR, 255));

        db.createTable(card_3_players);
        insertCard(db, card_3_players.getName(), "HERZ", "ASS");
        insertCard(db, card_3_players.getName(), "HERZ", "ZEHN");
        insertCard(db, card_3_players.getName(), "HERZ", "KÖNIG");
        insertCard(db, card_3_players.getName(), "HERZ", "OBER");
        insertCard(db, card_3_players.getName(), "HERZ", "UNTER");
        insertCard(db, card_3_players.getName(), "SHELL", "ASS");
        insertCard(db, card_3_players.getName(), "SHELL", "ZEHN");
        insertCard(db, card_3_players.getName(), "SHELL", "KÖNIG");
        insertCard(db, card_3_players.getName(), "SHELL", "OBER");
        insertCard(db, card_3_players.getName(), "SHELL", "UNTER");
        insertCard(db, card_3_players.getName(), "EICHEL", "ASS");
        insertCard(db, card_3_players.getName(), "EICHEL", "ZEHN");
        insertCard(db, card_3_players.getName(), "EICHEL", "KÖNIG");
        insertCard(db, card_3_players.getName(), "EICHEL", "OBER");
        insertCard(db, card_3_players.getName(), "EICHEL", "UNTER");
        insertCard(db, card_3_players.getName(), "BLATT", "ASS");
        insertCard(db, card_3_players.getName(), "BLATT", "ZEHN");
        insertCard(db, card_3_players.getName(), "BLATT", "KÖNIG");
        insertCard(db, card_3_players.getName(), "BLATT", "OBER");
        insertCard(db, card_3_players.getName(), "BLATT", "UNTER");
    }

    public static void create_4_player_Table(HSQLDatabase db) throws SQLException {
        Table card_4_players = new Table("players_4");
        card_4_players.addColumn(new Column("type", Datatype.VARCHAR, 255));
        card_4_players.addColumn(new Column("name", Datatype.VARCHAR, 255));

        db.createTable(card_4_players);
        insertCard(db, card_4_players.getName(), "HERZ", "ASS");
        insertCard(db, card_4_players.getName(), "HERZ", "ZEHN");
        insertCard(db, card_4_players.getName(), "HERZ", "KÖNIG");
        insertCard(db, card_4_players.getName(), "HERZ", "OBER");
        insertCard(db, card_4_players.getName(), "HERZ", "UNTER");
        insertCard(db, card_4_players.getName(), "HERZ", "SIEBEN");
        insertCard(db, card_4_players.getName(), "SHELL", "ASS");
        insertCard(db, card_4_players.getName(), "SHELL", "ZEHN");
        insertCard(db, card_4_players.getName(), "SHELL", "KÖNIG");
        insertCard(db, card_4_players.getName(), "SHELL", "OBER");
        insertCard(db, card_4_players.getName(), "SHELL", "UNTER");
        insertCard(db, card_4_players.getName(), "SHELL", "SIEBEN");
        insertCard(db, card_4_players.getName(), "EICHEL", "ASS");
        insertCard(db, card_4_players.getName(), "EICHEL", "ZEHN");
        insertCard(db, card_4_players.getName(), "EICHEL", "KÖNIG");
        insertCard(db, card_4_players.getName(), "EICHEL", "OBER");
        insertCard(db, card_4_players.getName(), "EICHEL", "UNTER");
        insertCard(db, card_4_players.getName(), "EICHEL", "SIEBEN");
        insertCard(db, card_4_players.getName(), "BLATT", "ASS");
        insertCard(db, card_4_players.getName(), "BLATT", "ZEHN");
        insertCard(db, card_4_players.getName(), "BLATT", "KÖNIG");
        insertCard(db, card_4_players.getName(), "BLATT", "OBER");
        insertCard(db, card_4_players.getName(), "BLATT", "UNTER");
        insertCard(db, card_4_players.getName(), "BLATT", "SIEBEN");
    }

    public static void create_3_player_Combos_Table(HSQLDatabase db) throws SQLException {
        Table combos_3_players = new Table("players_3_combos");
        combos_3_players.addColumn(new Column("name", Datatype.VARCHAR, 255));
        combos_3_players.addColumn(new Column("points", Datatype.INTEGER));

        db.createTable(combos_3_players);
        insertCombo(db, combos_3_players.getName(),"BINOKEL", 40);
        insertCombo(db, combos_3_players.getName(),"DOPPELTER_BINOKEL", 300);
        insertCombo(db, combos_3_players.getName(),"RUNDGANG", 240);
        insertCombo(db, combos_3_players.getName(),"VIER_ASS", 100);
        insertCombo(db, combos_3_players.getName(),"VIER_KÖNIGE", 80);
        insertCombo(db, combos_3_players.getName(),"VIER_OBER", 60);
        insertCombo(db, combos_3_players.getName(),"VIER_UNTER", 40);
        insertCombo(db, combos_3_players.getName(),"ACHT_ASS", 1000);
        insertCombo(db, combos_3_players.getName(),"ACHT_KÖNIGE", 1000);
        insertCombo(db, combos_3_players.getName(),"ACHT_OBER", 1000);
        insertCombo(db, combos_3_players.getName(),"ACHT_UNTER", 1000);
        insertCombo(db, combos_3_players.getName(),"FAMILIE", 100);
        insertCombo(db, combos_3_players.getName(),"DOPPELTE_FAMILIE", 1500);
        insertCombo(db, combos_3_players.getName(),"PAAR", 20);
        insertCombo(db, combos_3_players.getName(),"DOPPELTES_PAAR", 40);
    }

    public static void create_card_assets_Table(HSQLDatabase db) throws SQLException {
        Table card_assets = new Table("card_assets");
        card_assets.addColumn(new Column("type", Datatype.VARCHAR, 255));
        card_assets.addColumn(new Column("name", Datatype.VARCHAR, 255));
        card_assets.addColumn(new Column("png", Datatype.CLOB));
        db.createTable(card_assets);

        try {
            File file = new File("type_name.png");
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            String s = new String(Base64.getEncoder().encode(bytes), "UTF-8");
            // TODO write into DB
        } catch (IOException e) {

        }
    }

    private static void insertCard(HSQLDatabase db, String tableName, String type, String name) throws SQLException {
        for (int i = 0; i < 2 ; i++) {
            db.insertInto(tableName, new Value(type), new Value(name));
        }
    }

    private static void insertCombo(HSQLDatabase db, String tableName, String name, int points) throws SQLException {
        db.insertInto(tableName, new Value(name), new Value(points));
    }
}
