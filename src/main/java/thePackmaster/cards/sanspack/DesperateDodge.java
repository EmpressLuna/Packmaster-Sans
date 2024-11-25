package thePackmaster.cards.sanspack;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import thePackmaster.powers.sanspack.SidestepPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

public class DesperateDodge extends AbstractSansCard {
    public final static String ID = makeID("DesperateDodge");

    public DesperateDodge() {
        super(ID, 1, AbstractCard.CardType.SKILL, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
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
        applyToSelf(new SidestepPower(p, 2));
        applyToSelf(new VulnerablePower(p, 3, false));
    }
}
