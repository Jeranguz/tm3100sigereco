package ucr.ac.cr.sigereco.modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T15:08:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ConsultaTb.class)
public class ConsultaTb_ { 

    public static volatile SingularAttribute<ConsultaTb, Date> fechaHora;
    public static volatile SingularAttribute<ConsultaTb, Integer> id;
    public static volatile ListAttribute<ConsultaTb, RecetaTb> recetaTbList;

}