from flask_cors import CORS

from flask import Flask, request, Response, jsonify, render_template
import json
import pandas as pd
import csv

app = Flask(__name__)

CORS(app, resources={r'*': {'origins': '*'}})

#DB에서 데이터 가져오기
sales = pd.read_csv(r'C:\Users\young\OneDrive\바탕 화면\영철이팀\data_table\sales.csv', encoding='cp949')


#@app.route('/')
#def index():
#    return render_template("/thymeleaf/mac/bigdata/test.html")

@app.route("/dataTable", methods = ["POST"])
def connect():
#1. 쿼리문 넣고
    year = 2017
    quarter = 1
    svc_name = '네일숍'
    trdar_name = '명지대학교'
    sales2=sales.loc[(sales['STDR_YY_CD']==year) & (sales['STDR_QU_CD']==quarter)
        &(sales['SVC_INDUTY_CD_NM']==svc_name) &(sales['TRDAR_CD_NM']==trdar_name)]
    
#2. 데이터 분기하고
    check_co = '금액'
    if check_co == '금액':
    #금액
        sales3=sales2[['STDR_YY_CD','STDR_QU_CD','TRDAR_SE_CD_NM','MDWK_SELNG_AMT','WKEND_SELNG_AMT',
               'MON_SELNG_AMT','TUES_SELNG_AMT','WED_SELNG_AMT','THUR_SELNG_AMT','FRI_SELNG_AMT',
              'SAT_SELNG_AMT','SUN_SELNG_AMT','TMZON_00_06_SELNG_AMT','TMZON_06_11_SELNG_AMT',
               'TMZON_11_14_SELNG_AMT','TMZON_14_17_SELNG_AMT','TMZON_17_21_SELNG_AMT','TMZON_21_24_SELNG_AMT',
              'ML_SELNG_AMT','FML_SELNG_AMT','AGRDE_10_SELNG_AMT','AGRDE_20_SELNG_AMT','AGRDE_30_SELNG_AMT',
               'AGRDE_40_SELNG_AMT','AGRDE_50_SELNG_AMT','AGRDE_60_ABOVE_SELNG_AMT','STOR_CO']]
    elif check_co == '건수':
    #건수
        sales3 = sales2[['STDR_YY_CD','STDR_QU_CD','TRDAR_SE_CD_NM','MDWK_SELNG_CO','WKEND_SELNG_CO',
                   'MON_SELNG_CO','TUES_SELNG_CO','WED_SELNG_CO','THUR_SELNG_CO','FRI_SELNG_CO',
                   'SAT_SELNG_CO','SUN_SELNG_CO','TMZON_00_06_SELNG_CO','TMZON_06_11_SELNG_CO',
                   'TMZON_11_14_SELNG_CO','TMZON_14_17_SELNG_CO','TMZON_17_21_SELNG_CO',
                   'TMZON_21_24_SELNG_CO','ML_SELNG_CO','FML_SELNG_CO','AGRDE_10_SELNG_CO',
                   'AGRDE_20_SELNG_CO','AGRDE_30_SELNG_CO','AGRDE_40_SELNG_CO','AGRDE_50_SELNG_CO','AGRDE_60_ABOVE_SELNG_CO',
                   'STOR_CO']]
    
    sales3.index = ['sales']
    week_data = sales3.iloc[:,5:12]
    
    print('app 넘어옴')
    
    js = week_data.to_json(orient = 'index')  #columns도 사용가능, index, records
    #real_js=js[1:-1] records 사용시
    
#3. html로 넘기기
    return js
    
if __name__ == '__main__':
    app.run(debug=True)