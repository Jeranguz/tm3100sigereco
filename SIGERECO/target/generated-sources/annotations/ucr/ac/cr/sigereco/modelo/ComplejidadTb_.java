package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T22:33:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ComplejidadTb.class)
public class ComplejidadTb_ { 

    public static volatile SingularAttribute<ComplejidadTb, Integer> id;
    public static volatile SingularAttribute<ComplejidadTb, String> nombre;
    public static volatile ListAttribute<ComplejidadTb, RecetaTb> recetaTbList;

}