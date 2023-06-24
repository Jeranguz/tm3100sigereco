package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.CategoriaTb;
import ucr.ac.cr.sigereco.modelo.ComplejidadTb;
import ucr.ac.cr.sigereco.modelo.ConsultaTb;
import ucr.ac.cr.sigereco.modelo.OcasionTb;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1Tb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-24T12:34:47", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(RecetaTb.class)
public class RecetaTb_ { 

    public static volatile SingularAttribute<RecetaTb, String> descripcion;
    public static volatile SingularAttribute<RecetaTb, String> instrucciones;
    public static volatile SingularAttribute<RecetaTb, Integer> porciones;
    public static volatile ListAttribute<RecetaTb, ComplejidadTb> complejidadTbList;
    public static volatile SingularAttribute<RecetaTb, Integer> minutosPreparacion;
    public static volatile ListAttribute<RecetaTb, OcasionTb> ocasionTbList;
    public static volatile SingularAttribute<RecetaTb, String> imagen;
    public static volatile SingularAttribute<RecetaTb, Integer> minutosCoccion;
    public static volatile SingularAttribute<RecetaTb, String> nombre;
    public static volatile ListAttribute<RecetaTb, UsuarioHasReceta1Tb> usuarioHasReceta1TbList;
    public static volatile ListAttribute<RecetaTb, CategoriaTb> categoriaTbList;
    public static volatile SingularAttribute<RecetaTb, Integer> id;
    public static volatile ListAttribute<RecetaTb, ConsultaTb> consultaTbList;
    public static volatile ListAttribute<RecetaTb, UsuarioHasRecetaTb> usuarioHasRecetaTbList;
    public static volatile ListAttribute<RecetaTb, RecetaHasIngredienteTb> recetaHasIngredienteTbList;

}