package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WeightOfYourSins extends AbstractSansCard {
    public final static String ID = makeID("WeightOfYourSins");

    public WeightOfYourSins() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }
}
