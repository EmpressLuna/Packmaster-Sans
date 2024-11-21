package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class KarmicBlast extends AbstractSansCard {
    public final static String ID = makeID("KarmicBlast");

    public KarmicBlast() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 1;
        magicNumber = 20;
        baseMagicNumber = magicNumber;
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }
}
