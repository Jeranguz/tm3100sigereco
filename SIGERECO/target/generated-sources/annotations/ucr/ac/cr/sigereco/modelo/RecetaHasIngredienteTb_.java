package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.IngredienteTb;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTbPK;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UnidadMedidaTb;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T11:55:48", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T11:52:21", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> f08a4a8443cef8ee69a83aada9753a3eb75981ce
@StaticMetamodel(RecetaHasIngredienteTb.class)
public class RecetaHasIngredienteTb_ { 

    public static volatile SingularAttribute<RecetaHasIngredienteTb, RecetaTb> recetaTb;
    public static volatile ListAttribute<RecetaHasIngredienteTb, UnidadMedidaTb> unidadMedidaTbList;
    public static volatile SingularAttribute<RecetaHasIngredienteTb, RecetaHasIngredienteTbPK> recetaHasIngredienteTbPK;
    public static volatile SingularAttribute<RecetaHasIngredienteTb, String> cantidad;
    public static volatile SingularAttribute<RecetaHasIngredienteTb, IngredienteTb> ingredienteTb;

}