package coop.rchain.syntax.rholang.Absyn; // Java Package generated by the BNF Converter.

public class PMatch extends Proc {
  public final Proc proc_;
  public final ListPMBranch listpmbranch_;
  public PMatch(Proc p1, ListPMBranch p2) { proc_ = p1; listpmbranch_ = p2; }

  public <R,A> R accept(coop.rchain.syntax.rholang.Absyn.Proc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof coop.rchain.syntax.rholang.Absyn.PMatch) {
      coop.rchain.syntax.rholang.Absyn.PMatch x = (coop.rchain.syntax.rholang.Absyn.PMatch)o;
      return this.proc_.equals(x.proc_) && this.listpmbranch_.equals(x.listpmbranch_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.proc_.hashCode())+this.listpmbranch_.hashCode();
  }


}
