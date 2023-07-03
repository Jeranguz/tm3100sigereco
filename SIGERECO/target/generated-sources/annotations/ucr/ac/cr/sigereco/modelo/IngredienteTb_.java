package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-02T23:36:38", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(IngredienteTb.class)
public class IngredienteTb_ { 

    public static volatile SingularAttribute<IngredienteTb, String> descripcion;
    public static volatile SingularAttribute<IngredienteTb, Integer> id;
    public static volatile SingularAttribute<IngredienteTb, String> nombre;
    public static volatile ListAttribute<IngredienteTb, RecetaHasIngredienteTb> recetaHasIngredienteTbList;

}