package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-01T22:42:38", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(OcasionTb.class)
public class OcasionTb_ { 

    public static volatile SingularAttribute<OcasionTb, Integer> id;
    public static volatile SingularAttribute<OcasionTb, String> nombre;
    public static volatile ListAttribute<OcasionTb, RecetaTb> recetaTbList;

}