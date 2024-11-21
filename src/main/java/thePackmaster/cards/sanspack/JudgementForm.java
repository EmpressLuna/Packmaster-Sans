package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.downfallpack.AbstractDownfallCard;
import thePackmaster.powers.sanspack.JudgementPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

public class JudgementForm extends AbstractDownfallCard {
    public final static String ID = makeID("JudgementForm");

    public JudgementForm() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new JudgementPower(p, 1));
    }

    public void upp() {
        isEthereal = false;
    }

}
