package thePackmaster.actions.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import thePackmaster.powers.sanspack.KarmaPower;

public class ReverseGravityAction extends AbstractGameAction {
    private final AbstractCreature p;
    private final AbstractMonster m;
    private final int magicNumber;

    public ReverseGravityAction(AbstractCreature source, AbstractMonster monster, int amount) {
        this.p = source;
        this.m = monster;
        this.magicNumber = amount;
    }

    public void update() {
        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && ((AbstractCard)AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 2)).type == AbstractCard.CardType.ATTACK) {
            this.addToTop(new ApplyPowerAction(this.m, AbstractDungeon.player, new KarmaPower(m, p, magicNumber), this.magicNumber));
        }

        this.isDone = true;
    }
}
