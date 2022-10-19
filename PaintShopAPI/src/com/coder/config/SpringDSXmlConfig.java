package com.coder.config;



import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.coder.model.AboutProductLanguage;
import com.coder.model.AboutProductLanguageId;
import com.coder.model.Admin;
import com.coder.model.AdminStatus;
import com.coder.model.Color;
import com.coder.model.ColorGroup;
import com.coder.model.DeliveryAddress;
import com.coder.model.DeliveryType;
import com.coder.model.Discount;
import com.coder.model.Feature;
import com.coder.model.FeatureLanguage;
import com.coder.model.FeatureLanguageId;
import com.coder.model.Folder;
import com.coder.model.FreeTool;
import com.coder.model.GroupLanguage;
import com.coder.model.GroupLanguageId;
import com.coder.model.Guide;
import com.coder.model.GuideLanguage;
import com.coder.model.GuideLanguageId;
import com.coder.model.Language;
import com.coder.model.Litreage;
import com.coder.model.Member;
import com.coder.model.MemberStatus;
import com.coder.model.OnePayPaymentMethod;
import com.coder.model.OrderForm;
import com.coder.model.OrderStatus;
import com.coder.model.PaymentMethod;
import com.coder.model.Product;
import com.coder.model.ProductGroup;
import com.coder.model.ProductMedia;
import com.coder.model.ProductOrder;
import com.coder.model.ProductQuality;
import com.coder.model.ProductStatus;
import com.coder.model.ProductTitleLanguage;
import com.coder.model.ProductTitleLanguageId;
import com.coder.model.ProductType;
import com.coder.model.QtyUnit;
import com.coder.model.Shop;
import com.coder.model.ShopStatus;
import com.coder.model.ToolLanguage;
import com.coder.model.ToolLanguageId;
import com.coder.model.TypeLanguage;
import com.coder.model.TypeLanguageId;



@Configuration//spring.xml
@ComponentScan(basePackages={"com.coder"}) //<context:component-scan
@PropertySources({ //resources/database.properties
		@PropertySource("classpath:application.properties")
})
@EnableTransactionManagement
public class SpringDSXmlConfig {
	@Autowired
	private Environment environment;	
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(
		this.environment.getProperty("jdbc.driverClassName"));
		ds.setUrl(this.environment.getProperty("jdbc.url"));
		ds.setUsername(this.environment.getProperty("jdbc.username"));
		ds.setPassword(this.environment.getProperty("jdbc.password"));
		return ds;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sf){
		HibernateTransactionManager tm=new HibernateTransactionManager(sf);
		return tm;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(){
		LocalSessionFactoryBuilder b=new LocalSessionFactoryBuilder(getDataSource());
		
		b.addAnnotatedClass(AboutProductLanguage.class);
		b.addAnnotatedClass(AboutProductLanguageId.class);
		b.addAnnotatedClass(Admin.class);
		b.addAnnotatedClass(AdminStatus.class);
		b.addAnnotatedClass(Color.class);
		b.addAnnotatedClass(ColorGroup.class);
		b.addAnnotatedClass(DeliveryAddress.class);
		b.addAnnotatedClass(DeliveryType.class);
		b.addAnnotatedClass(Discount.class);
		b.addAnnotatedClass(Feature.class);
		b.addAnnotatedClass(FeatureLanguage.class);
		b.addAnnotatedClass(FeatureLanguageId.class);
		b.addAnnotatedClass(Folder.class);
		b.addAnnotatedClass(FreeTool.class);
		b.addAnnotatedClass(GroupLanguage.class);
		b.addAnnotatedClass(GroupLanguageId.class);
		b.addAnnotatedClass(Guide.class);
		b.addAnnotatedClass(GuideLanguage.class);
		b.addAnnotatedClass(GuideLanguageId.class);
		b.addAnnotatedClass(Language.class);
		b.addAnnotatedClass(Litreage.class);
		b.addAnnotatedClass(Member.class);
		b.addAnnotatedClass(MemberStatus.class);
		b.addAnnotatedClass(OnePayPaymentMethod.class);
		b.addAnnotatedClass(OrderForm.class);
		b.addAnnotatedClass(OrderStatus.class);
		b.addAnnotatedClass(PaymentMethod.class);
		b.addAnnotatedClass(Product.class);
		b.addAnnotatedClass(ProductGroup.class);
		b.addAnnotatedClass(ProductMedia.class);
		b.addAnnotatedClass(ProductOrder.class);
		b.addAnnotatedClass(ProductStatus.class);
		b.addAnnotatedClass(ProductTitleLanguage.class);
		b.addAnnotatedClass(ProductTitleLanguageId.class);
		b.addAnnotatedClass(ProductType.class);
		b.addAnnotatedClass(QtyUnit.class);
		b.addAnnotatedClass(Shop.class);
		b.addAnnotatedClass(ShopStatus.class);
		b.addAnnotatedClass(ToolLanguage.class);
		b.addAnnotatedClass(ToolLanguageId.class);
		b.addAnnotatedClass(TypeLanguage.class);
		b.addAnnotatedClass(TypeLanguageId.class);
		b.addAnnotatedClass(OnePayPaymentMethod.class);
		b.addAnnotatedClass(ProductQuality.class);
		
		return b.buildSessionFactory();
	}
}




