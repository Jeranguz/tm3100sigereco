package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T11:55:48", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T11:52:21", comments="EclipseLink-2.7.10.v20211216-rNA")
>>>>>>> f08a4a8443cef8ee69a83aada9753a3eb75981ce
@StaticMetamodel(IngredienteTb.class)
public class IngredienteTb_ { 

    public static volatile SingularAttribute<IngredienteTb, String> descripcion;
    public static volatile SingularAttribute<IngredienteTb, Integer> id;
    public static volatile SingularAttribute<IngredienteTb, String> nombre;
    public static volatile ListAttribute<IngredienteTb, RecetaHasIngredienteTb> recetaHasIngredienteTbList;

}