package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T22:33:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UnidadMedidaTb.class)
public class UnidadMedidaTb_ { 

    public static volatile SingularAttribute<UnidadMedidaTb, Integer> id;
    public static volatile SingularAttribute<UnidadMedidaTb, String> nombre;
    public static volatile ListAttribute<UnidadMedidaTb, RecetaHasIngredienteTb> recetaHasIngredienteTbList;

}