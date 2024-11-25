package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.sanspack.EndlessBonesPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

public class EndlessBones extends AbstractSansCard {
    public final static String ID = makeID("EndlessBones");

    public EndlessBones() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new EndlessBonesPower(p, 1));
    }
}
