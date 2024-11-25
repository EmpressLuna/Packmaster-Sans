package thePackmaster.packs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.sanspack.*;

import java.util.ArrayList;

public class SansPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID("SansPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public SansPack() {
        super(ID, NAME, DESC, AUTHOR, new PackSummary(3, 3, 4, 3, 2, PackSummary.Tags.Debuffs));
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(Blindside.ID);
        cards.add(BoneMissile.ID);
        cards.add(DesperateDodge.ID);
        cards.add(Encircle.ID);
        cards.add(JudgementForm.ID);
        cards.add(KarmicBlast.ID);
        cards.add(OpeningGambit.ID);
        cards.add(ReverseGravity.ID);
        cards.add(SurviveThis.ID);
        cards.add(EndlessBones.ID);
        return cards;
    }
}
