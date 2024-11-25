package thePackmaster.cards.sanspack;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.sanspack.EncirclePower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Encircle extends AbstractSansCard {
    public final static String ID = makeID("Encircle");

    public Encircle() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
        magicNumber = 1;
        baseMagicNumber = magicNumber;
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, magicNumber);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, magicNumber);
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, magicNumber);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, magicNumber);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToEnemy(m, new EncirclePower(m, 1));
    }
}
