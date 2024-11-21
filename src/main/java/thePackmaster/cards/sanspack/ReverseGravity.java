package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ReverseGravity extends AbstractSansCard {
    public final static String ID = makeID("ReverseGravity");

    public ReverseGravity() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        magicNumber = 1;
        baseMagicNumber = magicNumber;
        secondMagic = 6;
        baseSecondMagic = 6;
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }
}
