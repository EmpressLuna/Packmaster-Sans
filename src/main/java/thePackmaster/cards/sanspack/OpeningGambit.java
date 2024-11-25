package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.sanspack.KarmaPower;
import thePackmaster.powers.sanspack.SidestepPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToEnemy;
import static thePackmaster.util.Wiz.applyToSelf;

public class OpeningGambit extends AbstractSansCard {
    public final static String ID = makeID("OpeningGambit");

    public OpeningGambit() {
        super(ID, 0, AbstractCard.CardType.SKILL, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
        isInnate = true;
        exhaust = true;
        magicNumber = 2;
        baseMagicNumber = magicNumber;
        secondMagic = 1;
        baseSecondMagic = secondMagic;
        isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new KarmaPower(m, p, magicNumber));
        applyToSelf(new SidestepPower(p, secondMagic));
    }

    public void upp() {
        upgradeMagicNumber(1);
        upgradeSecondMagic(1);
    }

}
