package thePackmaster.actions.sanspack;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.InvinciblePower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import thePackmaster.powers.sanspack.KarmaPower;

import java.util.Iterator;

public class KarmaDamageAction extends AbstractGameAction {
    private static final float DURATION = 0.33F;

    public KarmaDamageAction(AbstractCreature target, AbstractCreature source, int amount, AbstractGameAction.AttackEffect effect) {
        this.setValues(target, source, amount);
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = effect;
        this.duration = 0.33F;
    }

    public void update() {
        if (AbstractDungeon.getCurrRoom().phase != AbstractRoom.RoomPhase.COMBAT) {
            this.isDone = true;
        } else {
            if (this.duration == 0.33F && this.target.currentHealth > 0) {
                AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect));
            }

            Iterator var1 = this.target.powers.iterator();
            int karmaDamage = 0;

            while(var1.hasNext()) {
                AbstractPower p = (AbstractPower)var1.next();
                if (!(p instanceof KarmaPower) && !(p instanceof InvinciblePower)) {
                    karmaDamage += Math.abs(p.amount);
                }
            }

            this.isDone = true;

            this.tickDuration();
            if (this.isDone) {
                if (this.target.currentHealth > 0) {
                    this.target.tint.color = Color.PURPLE.cpy();
                    this.target.tint.changeColor(Color.WHITE.cpy());
                    this.target.damage(new DamageInfo(this.source, karmaDamage, DamageInfo.DamageType.HP_LOSS));
                }

                AbstractPower p = this.target.getPower("Karma");
                if (p != null) {
                    --p.amount;
                    if (p.amount == 0) {
                        this.target.powers.remove(p);
                    } else {
                        p.updateDescription();
                    }
                }

                if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                    AbstractDungeon.actionManager.clearPostCombatActions();
                }

                this.addToTop(new WaitAction(0.1F));
            }

        }
    }
}

