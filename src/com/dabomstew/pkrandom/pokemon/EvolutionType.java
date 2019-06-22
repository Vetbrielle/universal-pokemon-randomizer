package com.dabomstew.pkrandom.pokemon;

public enum EvolutionType {
    /* @formatter:off */
    // Treat Gaia as 6th generation
    LEVEL(1, 1, 4, 4, 4, 4),
    STONE(2, 2, 7, 7, 8, 7),
    TRADE(3, 3, 5, 5, 5, 5),
    TRADE_ITEM(-1, 3, 6, 6, 6, 6),
    HAPPINESS(-1, 4, 1, 1, 1, 1),
    HAPPINESS_DAY(-1, 4, 2, 2, 2, 2),
    HAPPINESS_NIGHT(-1, 4, 3, 3, 3, 3),
    LEVEL_ATTACK_HIGHER(-1, 5, 8, 8, 9, 8),
    LEVEL_DEFENSE_HIGHER(-1, 5, 10, 10, 11, 10),
    LEVEL_ATK_DEF_SAME(-1, 5, 9, 9, 10, 9),
    LEVEL_LOW_PV(-1, -1, 11, 11, 12, 11),
    LEVEL_HIGH_PV(-1, -1, 12, 12, 13, 12),
    LEVEL_CREATE_EXTRA(-1, -1, 13, 13, 14, 13),
    LEVEL_IS_EXTRA(-1, -1, 14, 14, 15, 14),
    LEVEL_HIGH_BEAUTY(-1, -1, 15, 15, 16, 15),
    STONE_MALE_ONLY(-1, -1, -1, 16, 17, -1),
    STONE_FEMALE_ONLY(-1, -1, -1, 17, 18, -1),
    LEVEL_ITEM_DAY(-1, -1, -1, 18, 19, -1),
    LEVEL_ITEM_NIGHT(-1, -1, -1, 19, 20, -1),
    LEVEL_WITH_MOVE(-1, -1, -1, 20, 21, -1),
    LEVEL_WITH_OTHER(-1, -1, -1, 21, 22, -1),
    LEVEL_MALE_ONLY(-1, -1, -1, 22, 23, -1),
    LEVEL_FEMALE_ONLY(-1, -1, -1, 23, 24, -1),
    LEVEL_ELECTRIFIED_AREA(-1, -1, -1, 24, 25, -1),
    LEVEL_MOSS_ROCK(-1, -1, -1, 25, 26, -1),
    LEVEL_ICY_ROCK(-1, -1, -1, 26, 27, -1),
    TRADE_SPECIAL(-1, -1, -1, -1, 7, -1),
    GAIA_FAIRY_MOVE(-1, -1, -1, -1, -1, 16),
    GAIA_LEVEL_RAIN(-1, -1, -1, -1, -1, 17),
    GAIA_LEVEL_DARK_PKMN(-1, -1, -1, -1, -1, 18),
    GAIA_LEVEL_MALE(-1, -1, -1, -1, -1, 19),
    GAIA_LEVEL_FEMALE(-1, -1, -1, -1, -1, 20),
    GAIA_LEARN_MOVE(-1, -1, -1, -1, -1, 21),
    GAIA_PKMN_PARTY(-1, -1, -1, -1, -1, 22),
    GAIA_LEVEL_MAP(-1, -1, -1, -1, -1, 23),
    GAIA_ITEM_MALE(-1, -1, -1, -1, -1, 24),
    GAIA_ITEM_FEMALE(-1, -1, -1, -1, -1, 25),
    MEGA_EVOLVE(-1, -1, -1, -1, -1, 254),
    NONE(-1, -1, -1, -1, -1, -1);
    /* @formatter:on */

    private int[] indexNumbers;
    private static EvolutionType[][] reverseIndexes = new EvolutionType[6][255];

    private EvolutionType(int... indexes) {
        this.indexNumbers = indexes;
    }

    static {
        for (EvolutionType et : EvolutionType.values()) {
            for (int generation = 0; generation < et.indexNumbers.length; generation++) {
                if (et.indexNumbers[generation] > 0 && reverseIndexes[generation][et.indexNumbers[generation]] == null) {
                    reverseIndexes[generation][et.indexNumbers[generation]] = et;
                }
            }
        }
    }


    public int toIndex(int generation) { return indexNumbers[generation - 1]; }

    public static EvolutionType fromIndex(int generation, int index) { return reverseIndexes[generation - 1][index]; }

    public boolean usesLevel() {
        return (this == LEVEL) || (this == LEVEL_ATTACK_HIGHER) || (this == LEVEL_DEFENSE_HIGHER)
                || (this == LEVEL_ATK_DEF_SAME) || (this == LEVEL_LOW_PV) || (this == LEVEL_HIGH_PV)
                || (this == LEVEL_CREATE_EXTRA) || (this == LEVEL_IS_EXTRA) || (this == LEVEL_MALE_ONLY)
                || (this == LEVEL_FEMALE_ONLY);
    }
}
