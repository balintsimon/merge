import React from 'react';

const LoadingEmptyScreen = () => {
  return (
      <div className={"media"}>
        <div className="col-2 align-self-start" style={{...mainColumnStyle, ...{backgroundColor: "#e6b31e"}}}/>
        <div className="col-9 align-self-center" style={{...mainColumnStyle, ...{backgroundColor: "#343434"}}}>
          <div className="container-fluid" style={{animation: "fadein 2000ms"}}>
            <div className="row no-gutters">
              <div className="col-md-12">
                <div
                    style={{width: "100%", height: "500px", textAlign: "center", marginTop: "100px", color: "white"}}>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="col-1 align-self-end" style={{...mainColumnStyle, ...{backgroundColor: "#e6b31e"}}}/>
      </div>
  );
}

const mainColumnStyle = {
  display: "flex",
  flexFlow: "row wrap",
  height: "1500px",
  padding: "0"
}

export default LoadingEmptyScreen;